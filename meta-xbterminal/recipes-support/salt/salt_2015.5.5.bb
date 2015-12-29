require ${BPN}.inc

PR = "r2"

LIC_FILES_CHKSUM = "file://LICENSE;md5=b59c9134761722281bb895f65cb15e9a"

SRCNAME="salt"
SRC_URI = "http://pypi.python.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
           file://grains.conf \
           file://master.conf \
"

SRC_URI[md5sum] = "1a8e9e658d900b314fc3720ba51cc663"
SRC_URI[sha256sum] = "5cd8d317616abab691a83f7fd3f8bcf9ad8aecaa95fcfdc0f6d788de87f0beeb"
