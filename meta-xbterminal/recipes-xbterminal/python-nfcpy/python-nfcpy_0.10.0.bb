DESCRIPTION = "A Python module to read/write NFC tags or communicate with another NFC device."
HOMEPAGE = "https://nfcpy.readthedocs.org"
LICENSE = "EUPL-1.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e7a17001463f825f9e10cfda0954d6dc"

PR = "r0"

SRC_URI = "https://launchpad.net/nfcpy/0.10/${PV}/+download/nfcpy-${PV}.tar.gz \
           file://setup.py"
SRC_URI[md5sum] = "51be71afa72748c2a469ce65df886484"
SRC_URI[sha256sum] = "37c0aea3f6c4d787cc1b2fe39756531cc62607a5f64098fdbaba010bc99455c8"

inherit setuptools

S = "${WORKDIR}/${PV}"

do_configure_append() {
    cp ${WORKDIR}/setup.py ${S}/
}
