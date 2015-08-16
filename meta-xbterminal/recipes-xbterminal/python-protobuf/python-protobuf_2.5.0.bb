DESCRIPTION = "Protocol Buffers"
HOMEPAGE = "https://developers.google.com/protocol-buffers/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://README.txt;md5=e033d857b7297055cd91ecfcb2eb30db"

SRC_URI = "https://pypi.python.org/packages/source/p/protobuf/protobuf-${PV}.tar.gz"
SRC_URI[md5sum] = "338813f3629d59e9579fed9035ecd457"
SRC_URI[sha256sum] = "58292c459598c9297258bf57acc055f701c727f0154a86af8c0947dde37d8172"

inherit setuptools

S = "${WORKDIR}/protobuf-${PV}"
