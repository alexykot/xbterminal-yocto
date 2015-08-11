DESCRIPTION = "Python NTP library"
HOMEPAGE = "https://code.google.com/p/ntplib/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://ntplib.py;md5=31f237df17a1508eebebfa4ecb20c344"

SRC_URI = "https://pypi.python.org/packages/source/n/ntplib/ntplib-${PV}.tar.gz"
SRC_URI[md5sum] = "c7cc8e9b09f40c84819859d70b7784ca"
SRC_URI[sha256sum] = "c4621b64d50be9461d9bd9a71ba0b4af06fbbf818bbd483752d95c1a4e273ede"

inherit setuptools

S = "${WORKDIR}/ntplib-${PV}"
