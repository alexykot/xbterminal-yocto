#!/bin/bash
set -e

# X server
apt-get update
apt-get install --yes xinit
sed -i 's/allowed_users=console/allowed_users=anybody/g' /etc/X11/Xwrapper.config

# Utils
apt-get install --yes dosfstools htop mc

# Install required packages
# http://www.yoctoproject.org/docs/current/yocto-project-qs/yocto-project-qs.html
apt-get install --yes gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat libsdl1.2-dev xterm

# Copy SSH config
su - vagrant -c "cp /vagrant/ssh_config .ssh/config"

# Prepare build environment
su - vagrant <<"EOF"
git clone -b fido git://git.yoctoproject.org/poky
git clone -b fido git://git.openembedded.org/meta-openembedded
git clone -b fido https://github.com/Freescale/meta-fsl-arm
git clone -b fido https://github.com/Freescale/meta-fsl-arm-extra
ln -s   /vagrant xbterminal-firmware
source oe-init-build-env
cp /vagrant/conf/bblayers.conf conf/
cp /vagrant/conf/local.conf conf/
EOF
