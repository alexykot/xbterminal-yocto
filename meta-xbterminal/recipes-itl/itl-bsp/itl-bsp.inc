DESCRIPTION = "ITL BSP library"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=bba292d8225b99f2596365092d239929"

SRC_URI = "file://ITL_BSP_lib.h \
           file://ITL_BSP_Error.h \
           file://libITL_BSP.so \
           file://APM_STM32.bin \
           file://LICENSE"

S = "${WORKDIR}"

do_install () {
    install -d ${D}${libdir}/
    install -m 0644 ${S}/libITL_BSP.so ${D}${libdir}/libITL_BSP.so

    install -d ${D}${exec_prefix}/local/firmware
    install -m 0644 ${S}/APM_STM32.bin ${D}${exec_prefix}/local/firmware/APM_STM32.bin

    install -d ${D}${includedir}/itl
    install -m 0644 ${S}/ITL_BSP_lib.h ${D}${includedir}/itl/ITL_BSP_lib.h
    install -m 0644 ${S}/ITL_BSP_Error.h ${D}${includedir}/itl/ITL_BSP_Error.h
}

FILES_${PN} = "${libdir}/libITL_BSP.so \
               ${exec_prefix}/local/firmware/APM_STM32.bin \
               ${includedir}/itl \
               ${includedir}/itl/ITL_BSP_lib.h \
               ${includedir}/itl/ITL_BSP_Error.h"

FILES_SOLIBSDEV = ""
