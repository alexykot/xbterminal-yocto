DESCRIPTION = "A Python module to read/write NFC tags or communicate with another NFC device."
HOMEPAGE = "https://nfcpy.readthedocs.org"
LICENSE = "EUPL-1.1"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=acc743cb55d21276b2c8e5970bf8f0f0"

PR = "r0"

SRC_URI += " file://LICENSE"
SRC_URI[md5sum] = "c3844d44c9295416e8477274e98c81f7"
SRC_URI[sha256sum] = "7068f781408ebbc80246bddb417fb98662de15ffe5620a1202f027de522f0b5a"

inherit pypi setuptools

PYPI_PACKAGE_HASH = "0f2589816998694789617f1ef7461f3bce2e806cf69e9c9cc9cc3a2edf516de3"

RDEPENDS_${PN} = "python-libusb1 python-pyserial"
