DESCRIPTION = "PKCS#5 v2.0 PBKDF2 Module"
HOMEPAGE = "https://www.dlitz.net/software/python-pbkdf2/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.txt;md5=b6948f1f30b14743a80831eea2c7dfba"

SRC_URI = "https://pypi.python.org/packages/source/p/pbkdf2/pbkdf2-${PV}.tar.gz"
SRC_URI[md5sum] = "40cda566f61420490206597243dd869f"
SRC_URI[sha256sum] = "ac6397369f128212c43064a2b4878038dab78dab41875364554aaf2a684e6979"

inherit setuptools

S = "${WORKDIR}/pbkdf2-${PV}"
