DESCRIPTION = "Python bindings for ITL BSP library"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=267210cb205707edc452aca739057bff"

PR = "r0"

SRC_URI = "file://extension.c \
           file://setup.py \
           file://LICENSE"

S = "${WORKDIR}"

inherit setuptools

DEPENDS += "itl-bsp"
RDEPENDS_${PN} = "itl-bsp"
