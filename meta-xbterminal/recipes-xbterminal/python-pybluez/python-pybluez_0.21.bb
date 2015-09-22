DESCRIPTION = "Bluetooth Python extension module"
HOMEPAGE = "https://karulis.github.io/pybluez"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8a71d0475d08eee76d8b6d0c6dbec543"

PR = "r1"

SRC_URI = "https://pypi.python.org/packages/source/P/PyBluez/PyBluez-${PV}.zip"
SRC_URI[md5sum] = "cdca662fa8b87c036427e2a655cfab75"
SRC_URI[sha256sum] = "c10966bac1c62b025bb97a1141e6fc87adad8038ff2e5402ce5e9b5f1c0ebb91"

inherit setuptools

S = "${WORKDIR}/PyBluez-${PV}"

DEPENDS += "bluez4"

RDEPENDS_${PN} = "bluez4"
