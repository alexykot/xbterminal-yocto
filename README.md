## Create VM and build environment

```
git clone git@bitbucket.org:xbterminal/apm-yocto.git
cd apm-yocto
vagrant up
vagrant ssh
source poky/oe-init-build-env
```

Build environment could be updated later using `vagrant provision` command.

## Build image

There are two images:

* [core-image-xbt](meta-xbterminal/images/core-image-xbt.bb) - with SSH disabled, xbterminal-init service starts automatically.
* [core-image-xbt-dev](meta-xbterminal/images/core-image-xbt-dev.bb) - with SSH enabled, xbt-init script must be run manually.

Built images can also be found at https://repo.xbthq.co.uk:8080/

### Build

Put the xbterminal-firmware installation packages into directory `meta-xbterminal/recipes-xbterminal/xbterminal-firmware/files`.

Then build an image:

```
bitbake core-image-xbt-dev
```

### Boot

Write a **imx6ulevk-itl** image to SD card:

```
sudo dd if=core-image-xbt-dev-imx6ulevk-itl.sdcard of=/dev/mmcblk0 bs=1M
```

### Login

```
User: root  
Password: root
```
