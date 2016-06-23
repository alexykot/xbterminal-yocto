DESCRIPTION = "The ssl.match_hostname() function from Python 3.5."
HOMEPAGE = "http://bitbucket.org/brandon/backports.ssl_match_hostname"
LICENSE = "Python-2.0"
LIC_FILES_CHKSUM = "file://backports/ssl_match_hostname/LICENSE.txt;md5=27a27d83b5b4a5fdb34a152fc19c6166"

PR = "r0"

SRC_URI[md5sum] = "c03fc5e2c7b3da46b81acf5cbacfe1e6"
SRC_URI[sha256sum] = "502ad98707319f4a51fa2ca1c677bd659008d27ded9f6380c79e8932e38dcdf2"

inherit pypi

PYPI_PACKAGE = "backports.ssl_match_hostname"
PYPI_PACKAGE_HASH = "76212dc61178a2038a5cb35d14b61467c6ac632791ed05131dda72c20e7b9e23"
