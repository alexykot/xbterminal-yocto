PR = "r1"

DESCRIPTION = "XBTerminal HQ Repository"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=4eed5be50c30ca03c23569314c3895ec"

RDEPENDS_${PN} = "\
                 xbthq-certificates \ 
                 "

DEPENDS_${PN} += " apt "
SRC_URI = " file://00ssl-xbt-client-auth \
            file://xbt-dev.list \
            file://LICENSE \
            file://xbt.key \
            file://xbt.crt \
          "

inherit allarch

S = "${WORKDIR}"

do_install () {
	install -d ${D}/${sysconfdir}/apt/apt.conf.d/
	install -m 0644 ${WORKDIR}/00ssl-xbt-client-auth ${D}${sysconfdir}/apt/apt.conf.d/00ssl-xbt-client-auth

        install -d ${D}/${sysconfdir}/apt/sources.list.d/
        install -m 0644 ${WORKDIR}/xbt-dev.list ${D}${sysconfdir}/apt/apt.conf.d/xbt-dev.list

	install -m 0644 ${WORKDIR}/xbt.key ${D}${sysconfdir}/apt/xbt.key
	install -m 0644 ${WORKDIR}/xbt.crt ${D}${sysconfdir}/apt/xbt.crt
} 

FILES_${PN} += "\
		${sysconfdir}/apt/apt.conf.d/00ssl-xbt-client-auth \
		${sysconfdir}/apt/sources.list.d/xbt-dev.list \
                ${sysconfdir}/apt/xbt.key \
                ${sysconfdir}/apt/xbt.crt \
		"


INHIBIT_PACKAGE_STRIP = "1"

