DESCRIPTION = "A module to control BeagleBone IO channels"
HOMEPAGE = "https://github.com/adafruit/adafruit-beaglebone-io-python/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.rst;md5=6c89ebda10e2f2efefe5e681a9a0c1f1"

SRC_URI = "https://pypi.python.org/packages/source/A/Adafruit_BBIO/Adafruit_BBIO-${PV}.tar.gz \
           file://fix_setup.patch"
SRC_URI[md5sum] = "5f99f0caf52047ab3c9f8236cddaf8f1"
SRC_URI[sha256sum] = "122364531029956d0f787e7d4f0fe4c14e701babd184f69869c20a24d3083149"

inherit setuptools

S = "${WORKDIR}/Adafruit_BBIO-${PV}"
