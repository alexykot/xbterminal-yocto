DESCRIPTION = "Python HTTP for Humans."
HOMEPAGE = "http://python-requests.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c7869e52c8275537186de35e3cd5f9ec"

SRC_URI = "https://pypi.python.org/packages/source/r/requests/requests-${PV}.tar.gz"
SRC_URI[md5sum] = "7449ffdc8ec9ac37bbcd286003c80f00"
SRC_URI[sha256sum] = "1c1473875d846fe563d70868acf05b1953a4472f4695b7b3566d1d978957b8fc"

S = "${WORKDIR}/requests-${PV}"

inherit setuptools
