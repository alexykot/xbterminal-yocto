DESCRIPTION = "JSON-RPC transport realisation."
HOMEPAGE = "http://json-rpc.readthedocs.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE.txt;md5=d518b3868dfcb46ee3b2e342501fa46b"

PR = "r0"

SRC_URI += " file://LICENSE.txt"
SRC_URI[md5sum] = "24e9765de545ed2df6f06e229c88a9c8"
SRC_URI[sha256sum] = "d13e24396ac975ed0ae2f396833dc64148503939b9dff0a7a5ac16918f392585"

inherit pypi

PYPI_PACKAGE_HASH = "dfcc1ba8ca75b9e45eae5d146b9e45f64d344f616f89422ecfab9a7a6f0968b8"

