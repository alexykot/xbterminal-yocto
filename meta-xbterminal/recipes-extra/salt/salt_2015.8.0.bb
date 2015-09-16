
LIC_FILES_CHKSUM = "file://LICENSE;md5=b59c9134761722281bb895f65cb15e9a"

SRCNAME="salt"
SRC_URI = "http://pypi.python.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
           file://set_python_location_hashbang.patch \
           file://minion \
           file://salt-minion \
           file://salt-common.bash_completion \
           file://salt-common.logrotate \
           file://salt-api \
           file://salt-master \
           file://master \
           file://salt-syndic \
           file://cloud \
           file://roster \
"

SRC_URI[md5sum] = "a15842ef0582cca9d26143fe0a6180b7"
SRC_URI[sha256sum] = "71e1cb2eb1d4b30f3247f5590c00a2089190b8f9a90c9330dc9a65fae517ec9b"

require ${BPN}.inc

