do_install_append() {
    sed -i '/PrivateNetwork=yes/ s/^/#/' ${D}${systemd_unitdir}/system/systemd-hostnamed.service
}

SRC_URI_append = " https://github.com/pbx0/systemd/commit/b7db91f175ce755f72781b1431178237054cb432.patch;md5=968d586797429a00eaa80eebbfa34be1 "

SRC_URI[md5sum] = "968d586797429a00eaa80eebbfa34be1"
SRC_URI[sha256sum] = "4a44ba7eec45100ddfd159ca39e14ec3d248ba59ac661cbc514154d5a1ddafc1"

