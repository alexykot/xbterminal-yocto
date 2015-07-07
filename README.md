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

Boot:

```
xinit
runqemu qemuarm
```
