Create VM:

```
git clone git@bitbucket.org:xbterminal/xbterminal-yocto.git
cd xbterminal-yocto
vagrant up
```

Build an `core-image-xbt` image:

```
vagrant ssh
cd poky
source oe-init-build-env
bitbake core-image-xbt
```

Boot image:

```
xinit
runqemu qemuarm
```

User: root
Password: root
