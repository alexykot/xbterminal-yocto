require ${BPN}.inc

PR = "r1"

LIC_FILES_CHKSUM = "file://LICENSE;md5=b59c9134761722281bb895f65cb15e9a"

SRCNAME = "salt"
SRC_URI = "https://pypi.python.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
           file://grains.conf \
           file://master.conf \
           file://modules.conf \
"

SRC_URI[md5sum] = "5919fcb6be4deeafab9746febd7da1ef"
SRC_URI[sha256sum] = "2e9a262789b018f3443513105c0c6ae98934c9bc105a04cf9e5c073ef706218a"

RDEPENDS_${PN}-minion = "python  ${PN}-common (= ${EXTENDPKGV}) python-pycrypto python-msgpack python-pyzmq (>= 13.1.0) procps python-apt"
FILES_${PN}-minion = "${bindir}/${PN}-minion ${sysconfdir}/${PN}/minion.d/ ${CONFFILES_${PN}-minion} ${bindir}/${PN}-proxy"

RDEPENDS_${PN}-common = "python python-dateutil python-jinja2 python-pyyaml python-requests (>= 1.0.0) python-tornado (>= 4.2.1)"

RDEPENDS_${PN}-ssh = "python  ${PN}-common (= ${EXTENDPKGV}) python-msgpack"

RDEPENDS_${PN}-api = "python ${PN}-master"

RDEPENDS_${PN}-master = "python  ${PN}-common (= ${EXTENDPKGV}) python-pycrypto python-msgpack python-pyzmq (>= 13.1.0)"
FILES_${PN}-master = "${bindir}/${PN} ${bindir}/${PN}-cp ${bindir}/${PN}-key ${bindir}/${PN}-master ${bindir}/${PN}-run ${bindir}/${PN}-unity ${bindir}/spm ${CONFFILES_${PN}-master}"

RDEPENDS_${PN}-syndic = "python  ${PN}-master (= ${EXTENDPKGV})"

RDEPENDS_${PN}-cloud = "python  ${PN}-common (= ${EXTENDPKGV})"
