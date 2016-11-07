from fabric.api import task, local, run, cd, get, settings, shell_env, prefix


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
        with cd('build/tmp/deploy/images/{machine}'.format(machine=machine)):
            local('mkdir -p build')
            get('{image}-{machine}.sdcard.gz'.format(image=image, machine=machine),
                'build/')


@task
def clean():
    local("find . -name '*.pyc' -delete")
