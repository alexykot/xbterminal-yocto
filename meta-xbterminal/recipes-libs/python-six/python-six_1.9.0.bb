DESCRIPTION = "Python 2 and 3 compatibility utilities"
HOMEPAGE = "https://pythonhosted.org/six/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6f00d4a50713fa859858dd9abaa35b21"

SRC_URI = "https://pypi.python.org/packages/source/s/six/six-${PV}.tar.gz"
SRC_URI[md5sum] = "476881ef4012262dfc8adc645ee786c4"
SRC_URI[sha256sum] = "e24052411fc4fbd1f672635537c3fc2330d9481b18c0317695b46259512c91d5"

inherit setuptools

S = "${WORKDIR}/six-${PV}"
