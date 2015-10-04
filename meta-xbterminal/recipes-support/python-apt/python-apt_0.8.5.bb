DESCRIPTION = "Python bindings for libapt"
HOMEPAGE = "http://apt.alioth.debian.org/python-apt-doc/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING.GPL;md5=0636e73ff0215e8d672dc4c32c317bb3"

SRC_URI = "https://launchpad.net/python-apt/main/0.7.8/+download/python-apt-0.8.5.tar.gz"
SRC_URI[md5sum] = "fb0558bb84180aeee35ae4de8e922586"
SRC_URI[sha256sum] = "038407a74f041f3edebf3a5509d35552d11f8b4453f7c6ca76f9adc26c11c1ac"

inherit setuptools

S = "${WORKDIR}/python-apt-0.8.5"

DEPENDS += "apt python-pyflakes"
