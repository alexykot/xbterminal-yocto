Create VM:

```
git clone git@bitbucket.org:xbterminal/xbterminal-yocto.git
cd xbterminal-yocto
vagrant up
```

Build an image:

```
vagrant ssh
cd poky
source oe-init-build-env
bitbake -k core-image-xbt
```

Boot image:

```
runqemu qemuarm nographic
```

OR build libs:
```
bitbake python-pillow
bitbake python-cryptography
bitbake zbar
```
