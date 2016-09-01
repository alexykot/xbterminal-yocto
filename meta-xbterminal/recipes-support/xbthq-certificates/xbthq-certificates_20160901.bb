PR = "r1"

DESCRIPTION = "XBTerminal HQ CAs"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=4eed5be50c30ca03c23569314c3895ec"

RDEPENDS_${PN} = "\
                 ca-certificates \
                 "

DEPENDS_${PN} = "\
                 ca-certificates \
                 "

SRC_URI = " file://xbthq-dev.crt \
            file://LICENSE \
          "

inherit allarch

S = "${WORKDIR}"

do_install () {
	install -d  ${D}${prefix}/local/share/ca-certificates/xbthq/
	install -m 0644 ${WORKDIR}/xbthq-dev.crt ${D}${prefix}/local/share/ca-certificates/xbthq/


}

FILES_${PN} += "${prefix}/local/share/ca-certificates/xbthq/xbthq-dev.crt ${prefix}/local/share/ca-certificates ${prefix}/local/share/ca-certificates/xbthq ${prefix}/local/share ${prefix}/local"

pkg_postinst_${PN} () {
    SYSROOT="$D" update-ca-certificates
}

INHIBIT_PACKAGE_STRIP = "1"
