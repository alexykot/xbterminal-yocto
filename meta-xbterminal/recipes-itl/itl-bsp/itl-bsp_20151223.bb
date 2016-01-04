DESCRIPTION = "ITL BSP library"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=bba292d8225b99f2596365092d239929"

PR = "r0"

SRC_URI = "file://lib \
           file://inc \
           file://LICENSE"

S = "${WORKDIR}"

do_install () {
    install -d ${D}${libdir}/
    install -m 0644 ${S}/lib/libITL_BSP.so ${D}${libdir}/libITL_BSP.so

    install -d ${D}${includedir}/itl
    install -m 0644 ${S}/inc/ITL_BSP_lib.h ${D}${includedir}/itl/ITL_BSP_lib.h
}

FILES_${PN} = "${libdir}/libITL_BSP.so"
FILES_SOLIBSDEV = ""
