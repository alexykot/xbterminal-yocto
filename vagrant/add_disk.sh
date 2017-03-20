#!/bin/bash

set -e

if grep '/home' /etc/fstab > /dev/null 2>&1
then
    exit 0
fi

fdisk -u /dev/sdb <<EOF
n
p
1


t
8e
w
EOF

mkfs.ext4 /dev/sdb1
echo `blkid /dev/sdb1 | awk '{print$2}' | sed -e 's/"//g'` /home ext4 auto 0 0 >> /etc/fstab

# Backup, mount, restore
mv /home/vagrant /tmp/vagrant
mount /home
mv /tmp/vagrant /home/vagrant
