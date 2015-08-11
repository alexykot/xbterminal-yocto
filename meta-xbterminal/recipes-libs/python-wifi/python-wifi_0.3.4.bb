DESCRIPTION = "wifi, a Python interface"
HOMEPAGE = "https://wifi.readthedocs.org/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96054b336a7ea61f1acd5c14acdda526"

SRC_URI = "https://pypi.python.org/packages/source/w/wifi/wifi-${PV}.tar.gz"
SRC_URI[md5sum] = "2e84749103824061072e5dad30c79c6c"
SRC_URI[sha256sum] = "17b07269654b02936f500a88c85281a95ac211028b6547c4f78b61b83dd965c0"

S = "${WORKDIR}/wifi-${PV}"

inherit setuptools

INSANE_SKIP_${PN} = "installed-vs-shipped"
