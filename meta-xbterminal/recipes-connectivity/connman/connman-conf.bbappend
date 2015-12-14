FILESEXTRAPATHS_append := ":${THISDIR}/files"

SRC_URI_append_wandboard = " file://wired.config \
                             file://wired-setup \
                             file://settings"


do_install_append_wandboard() {
    install -m 0644 ${WORKDIR}/settings ${D}${localstatedir}/lib/connman
}
