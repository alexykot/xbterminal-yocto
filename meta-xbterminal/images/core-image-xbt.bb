SUMMARY = "An image that fully supports the XBTerminal device."
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "splash package-management"

IMAGE_INSTALL += "\
    packagegroup-core-x11-xserver \
    ntp \
    connman \
    connman-conf \
    connman-client \
    connman-wait-online \
    gnupg \
    xbthq-certificates \
    apt-xbthq-repository \
    salt-minion \
    salt-common \
    xbterminal \
    "

# Touchscreen calibrator
IMAGE_INSTALL_append_mx6ul = " xinit xset xterm xauth xinput-calibrator"

# Set root password
inherit extrausers
EXTRA_USERS_PARAMS = "usermod -P root root;"

# Swap file
IMAGE_INSTALL_append_imx6ulevk-itl = " swapfile "
IMAGE_ROOTFS_EXTRA_SPACE_imx6ulevk-itl = "102400"

# DNS
set_dns_servers () {
    DNS_SERVERS=$(cat /etc/resolv.conf | sed 's/^nameserver //' | tr '\n' ' ')
    echo "dns-nameservers ${DNS_SERVERS}" >> ${IMAGE_ROOTFS}/etc/network/interfaces
}
IMAGE_INSTALL_append_qemuarm = " resolvconf"
ROOTFS_POSTPROCESS_COMMAND_append_qemuarm = " set_dns_servers; "

QT_WEBKIT ?= "-no-webkit"
QT_PHONON ?= "-no-phonon"
QT_DBUS ?= "-no-qdbus"
