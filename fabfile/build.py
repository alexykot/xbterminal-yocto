import datetime

from fabric.api import task, local, run, lcd, cd, get, settings, shell_env, prefix


@task(default=True)
def image(machine='imx6ulevk-itl',
          image='core-image-xbt-dev',
          xbt_pkgv=None,
          xbt_pv=None):
    # Get vagrant ssh config
    ssh_config = {}
    local('vagrant up')
    output = local('vagrant ssh-config', capture=True)
    for line in output.splitlines()[1:]:
        key, value = line.strip().split(' ', 2)
        ssh_config[key] = value
    with settings(user=ssh_config['User'],
                  host_string=ssh_config['HostName'],
                  port=ssh_config['Port'],
                  key_filename=ssh_config['IdentityFile'].strip('"'),
                  disable_known_hosts=True):
        # Build image
        bb_vars = {
            'BB_ENV_EXTRAWHITE': 'MACHINE XBT_PKGV XBT_PV',
            'MACHINE': machine,
            'XBT_PKGV': xbt_pkgv or '',
            'XBT_PV': xbt_pv or '',
        }
        with prefix('. poky/oe-init-build-env'), shell_env(**bb_vars):
            run('bitbake {image}'.format(image=image))
        # Download image
        local('mkdir -p build')
        remote_image_dir = 'build/tmp/deploy/images/{machine}'.format(
            machine=machine)
        with lcd('build'), cd(remote_image_dir):
            image_file_name = '{image}-{machine}.sdcard.gz'.format(
                image=image,
                machine=machine)
            image_ts_file_name = '{image}-{machine}-{ts:%Y%m%d%H%M}.sdcard.gz'.format(
                image=image,
                machine=machine,
                ts=datetime.datetime.now())
            get(image_file_name, image_ts_file_name)
            local('rm -f {link_name}'.format(
                link_name=image_file_name))
            local('ln -s {file_name} {link_name}'.format(
                file_name=image_ts_file_name,
                link_name=image_file_name))


@task
def clean():
    local("find build/ -type f -name '*.sdcard.gz' -delete")
