FILESEXTRAPATHS_append := ":${THISDIR}/${PN}"

SRC_URI_append_wandboard = " file://wired.config \
                             file://wired-setup \
                             file://settings"
SRC_URI_append_imx6ulevk = " file://wired.config \
                             file://wired-setup \
                             file://settings"


do_install_append_wandboard() {
    install -m 0644 ${WORKDIR}/settings ${D}${localstatedir}/lib/connman
}

do_install_append_imx6ulevk() {
    install -m 0644 ${WORKDIR}/settings ${D}${localstatedir}/lib/connman
}
