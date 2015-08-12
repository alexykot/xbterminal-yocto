DESCRIPTION = "A Python module to read/write NFC tags or communicate with another NFC device."
HOMEPAGE = "https://nfcpy.readthedocs.org"
LICENSE = "EUPL-1.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e7a17001463f825f9e10cfda0954d6dc"

PR = "r1"

SRC_URI = "https://launchpad.net/nfcpy/0.9/${PV}/+download/nfcpy-${PV}.tar.gz \
           file://setup.py"
SRC_URI[md5sum] = "bb98b7c9d7c7b21c71b44a3df9d0bc43"
SRC_URI[sha256sum] = "a11a5874bc1ddf8cab311debcc1caa43f8f28678341ec9e37540457bf9160c0d"

inherit setuptools

S = "${WORKDIR}/nfcpy-${PV}"

do_configure_append() {
    cp ${WORKDIR}/setup.py ${S}/
}
