FILESEXTRAPATHS_append := ":${THISDIR}/${PN}"

SRC_URI_append_armv7a = " file://wired.config \
                          file://wired-setup \
                          file://settings"

do_install_append_armv7a() {
    install -m 0644 ${WORKDIR}/settings ${D}${localstatedir}/lib/connman
}
