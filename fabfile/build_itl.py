import re

from fabric.api import task, local, get, cd, hosts

import build


@task(default=True)
@hosts('blobs.xbthq.co.uk')
def image(prod='no'):
    """
    Usage:
        fab build_itl
            - build dev image
        fab build_itl:prod=yes
            - build production image
    """
    jenkins_build_dir = '/itl/xbterminal-firmware/build/'
    src_dir = 'meta-xbterminal/recipes-xbterminal/xbterminal/files/'
    local('mkdir -p {}'.format(src_dir))
    # Get sources
    with cd(jenkins_build_dir):
        get('PACKAGE_VERSION', 'build/PACKAGE_VERSION')
        xbt_pkgv = local('cat build/PACKAGE_VERSION', capture=True).strip()
        xbt_pv = re.sub(r'^(\d+\.\d+).*', r'\1.%', xbt_pkgv)
        get('xbterminal-firmware_{}_armhf.tar.gz'.format(xbt_pkgv),
            src_dir)
    # Build image
    build.image(machine='imx6ulevk-itl',
                image='core-image-xbt' if prod == 'yes' else 'core-image-xbt-dev',
                xbt_pkgv=xbt_pkgv,
                xbt_pv=xbt_pv)
    # Shutdown VM
    local('vagrant halt')


__all__ = ['image']

