DESCRIPTION = "PyUSB provides USB access on the Python language"
HOMEPAGE = "https://walac.github.io/pyusb/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=50d46bda6248a0b4a46a6d59a66ee08e"

PKGV = "1.0.0.final"
PR = "r0"

SRC_URI[md5sum] = "c8a571bfdba778555156af3facaea6fc"
SRC_URI[sha256sum] = "5b34ffa74ac34f330bff949c94ee00ec4a9d147234db17ee2eed2a67c0275368"

inherit pypi setuptools

PYPI_PACKAGE = "PyUSB"
PYPI_PACKAGE_HASH = "8a1966fb48a4905e472f5dfeda3a1bafac369fbf6d6fc5cf55b780864962652d"
S = "${WORKDIR}/pyusb-${PV}"

DEPENDS += "libusb1"
