SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_FEATURES += "splash package-management ssh-server-openssh"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "\
    packagegroup-core-x11-xserver xinit xset \
    util-linux git nano htop usbutils ntp \
    xbterminal-firmware \
    "

# Set root password
inherit extrausers
EXTRA_USERS_PARAMS = "usermod -P root root;"

# DNS
set_dns_servers () {
    DNS_SERVERS=$(cat /etc/resolv.conf | sed 's/^nameserver //' | tr '\n' ' ')
    echo "dns-nameservers ${DNS_SERVERS}" >> ${IMAGE_ROOTFS}/etc/network/interfaces
}
IMAGE_INSTALL_append_qemuarm = " resolvconf"
ROOTFS_POSTPROCESS_COMMAND_append_qemuarm = " set_dns_servers; "
