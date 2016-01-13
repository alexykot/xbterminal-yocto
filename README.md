## Create VM and build environment

```
git clone git@bitbucket.org:xbterminal/xbterminal-yocto.git
cd xbterminal-yocto
vagrant plugin install vagrant-vbguest
vagrant up
vagrant ssh
source poky/oe-init-build-env
```

## XBTerminal firmware

Put the installation package into directory `meta-xbterminal/recipes-xbterminal/xbterminal-firmware/files`.

## Build image

Edit `conf/local.conf` and choose a build target (**qemuarm**, **wandboard** or **imx6ulevk**).

Then build an image:

```
bitbake core-image-xbt-dev
```

To boot a **qemuarm** image:

```
xinit
runqemu qemuarm
```

To write a **wandboard** or **imx6ulevk** image to SD card:

```
sudo dd if=core-image-xbt-dev-wandboard.sdcard of=/dev/mmcblk0 bs=1M
```

Built images can also be found at https://repo.xbthq.co.uk:8080/

## Login

```
User: root  
Password: root
```
