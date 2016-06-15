FILESEXTRAPATHS_append := ":${THISDIR}/${PN}"

SRC_URI_append_mx6ul = " file://99-imx6ulevk.conf "

do_install_append_mx6ul() {
    install -m 0644 ${WORKDIR}/99-imx6ulevk.conf ${D}${datadir}/X11/xorg.conf.d/
}
