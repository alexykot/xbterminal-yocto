from fabric.api import task, local, run, cd, get, settings


@task(default=True)
def image(machine='imx6ulevk-itl', image='core-image-xbt-dev'):
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
        run('. poky/oe-init-build-env && bitbake {image}'.format(image=image))
        with cd('build/tmp/deploy/images/{machine}'.format(machine=machine)):
            local('mkdir -p build')
            get('{image}-{machine}.sdcard.gz'.format(image=image, machine=machine),
                'build/')


@task
def clean():
    local("find . -name '*.pyc' -delete")


