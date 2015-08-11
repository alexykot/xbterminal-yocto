DESCRIPTION = "IPv4/IPv6 manipulation library"
HOMEPAGE = "https://github.com/phihag/ipaddress"
LICENSE = "PSFL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7f538584cc3407bf76042def7168548a"

SRC_URI = "https://pypi.python.org/packages/source/i/ipaddress/ipaddress-${PV}.tar.gz;name=src \
           https://raw.githubusercontent.com/phihag/ipaddress/e98c02a4987a6cba3c0bc225c2115cf631ea9b33/LICENSE;name=lic \
           "
SRC_URI[src.md5sum] = "e2f2f6593b2b8a7e8abba0fbdf33f046"
SRC_URI[src.sha256sum] = "226f4be44c6cb64055e23060848266f51f329813baae28b53dc50e93488b3b3e"
SRC_URI[lic.md5sum] = "7f538584cc3407bf76042def7168548a"
SRC_URI[lic.sha256sum] = "38675419eb4a79ec616396d70f1254b3a433fb7088fb3f4cc9b6c0bcdcec6162"

inherit setuptools

S = "${WORKDIR}/ipaddress-${PV}"

do_configure_append() {
    mv ${WORKDIR}/LICENSE ${S}/
}
