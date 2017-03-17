# Install required packages
# https://www.yoctoproject.org/docs/2.0/yocto-project-qs/yocto-project-qs.html
yocto_required_pkgs:
  pkg:
    - installed
    - names:
      - gawk
      - wget
      - git-core
      - diffstat
      - unzip
      - texinfo
      - gcc-multilib
      - build-essential
      - chrpath
      - socat
      - libsdl1.2-dev
      - xterm

utils_pkgs:
  pkg:
    - installed
    - names:
      - dosfstools
      - htop
      - mc

yocto_repo:
  git.latest:
    - name: git://git.yoctoproject.org/poky
    - target: /home/vagrant/poky
    - rev: jethro
    - branch: jethro
    - user: vagrant

openembedded_repo:
  git.latest:
    - name: git://git.openembedded.org/meta-openembedded
    - target: /home/vagrant/meta-openembedded
    - rev: jethro
    - branch: jethro
    - user: vagrant

fsl_arm_repo:
  git.latest:
    - name: https://github.com/Freescale/meta-fsl-arm
    - target: /home/vagrant/meta-fsl-arm
    - rev: jethro
    - branch: jethro
    - user: vagrant

fsl_arm_extra_repo:
  git.latest:
    - name: https://github.com/Freescale/meta-freescale-3rdparty
    - target: /home/vagrant/meta-fsl-arm-extra
    - rev: jethro
    - branch: jethro
    - user: vagrant

xbt_repo:
  file:
    - symlink
    - name: /home/vagrant/xbterminal-yocto
    - target: /vagrant
    - user: vagrant

oe_init_build_env:
  cmd:
    - run
    - name: source poky/oe-init-build-env
    - runas: vagrant
    - require:
      - git: yocto_repo
      - git: openembedded_repo
      - git: fsl_arm_repo
      - git: fsl_arm_extra_repo
      - file: xbt_repo

bb_layers_conf:
  file:
    - managed
    - name: /home/vagrant/build/conf/bblayers.conf
    - source: /vagrant/conf/bblayers.conf
    - user: vagrant
    - require:
      - cmd: oe_init_build_env

bb_local_conf:
  file:
    - managed
    - name: /home/vagrant/build/conf/local.conf
    - source: /vagrant/conf/local.conf
    - user: vagrant
    - require:
      - cmd: oe_init_build_env
