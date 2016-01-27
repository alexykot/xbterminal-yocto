require images/core-image-xbt.bb

SUMMARY = "An image that fully supports the XBTerminal device (development version)."
LICENSE = "MIT"

IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_INSTALL_append = " openssh-sftp-server curl python-pip mc"

# Disable xbterminal services for dev image
disable_xbterminal_services () {
    rm -rf ${IMAGE_ROOTFS}/etc/systemd/system/multi-user.target.wants/xbterminal-*.service
}
ROOTFS_POSTPROCESS_COMMAND_append = " disable_xbterminal_services; "
