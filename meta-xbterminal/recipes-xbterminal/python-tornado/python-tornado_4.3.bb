DESCRIPTION = "Tornado is a Python web framework and asynchronous networking library."
HOMEPAGE = "http://www.tornadoweb.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.py;beginline=3;endline=15;md5=8d463fc66ff8f275354ffe88d1896e12"

PR = "r0"

SRC_URI[md5sum] = "d13a99dc0b60ba69f5f8ec1235e5b232"
SRC_URI[sha256sum] = "c9c2d32593d16eedf2cec1b6a41893626a2649b40b21ca9c4cac4243bde2efbf"

inherit pypi

PYPI_PACKAGE_HASH = "2129e64c97013e97d42d93b3d5997234a6f17455f3744847a7c16289289f8fa6"

RDEPENDS_${PN} += "\
    python-certifi \
    python-backports-abc \
    python-backports-ssl \
    python-singledispatch \
    "
