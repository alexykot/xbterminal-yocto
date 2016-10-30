require syslog-ng.inc

SRC_URI += " \
    file://fix-a-memory-leak-in-log_driver_free.patch \
    file://fix-config-libnet.patch \
    file://fix-invalid-ownership.patch \
    file://Fix-the-memory-leak-problem-for-mutex.patch \
    file://Fix-the-memory-leak-problem-when-HAVE_ENVIRON-defined.patch \
    file://configure.patch \
    file://dbifix.patch \
    file://syslog-ng.service-the-syslog-ng-service.patch \
"

SRC_URI[md5sum] = "e9f401615e92e5eb27396c995c1446ba"
SRC_URI[sha256sum] = "7be11df31ac7d716f1f952e22b5ae8e2049edd633a41b223776a853d9106f4e7"

# imported from http://cgit.openembedded.org/meta-openembedded/commit/meta-oe/recipes-support/syslog-ng/syslog-ng_3.6.4.bb?id=7a491f384c277ee42ac895fec6fc2ef70f15df4d
