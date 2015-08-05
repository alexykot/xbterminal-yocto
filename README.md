Create VM:

```
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
xinit
runqemu qemuarm
```

OR build libs:
```
bitbake python-pillow
bitbake python-cryptography
bitbake zbar
```
