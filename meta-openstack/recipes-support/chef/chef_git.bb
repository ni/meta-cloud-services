#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "Supports the deployment of OpenStack nodes"
DESCRIPTION = "Use chef-solo to help reconfigure and deployment of controller \
and compute nodes. Install script downloaded from this link \
(https://www.opscode.com/chef/install.sh) and the attached archives created from it."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8f7bb094c7232b058c7e9f2e431f389c"

PR = "r0"

BPV = "12.5.1"
PV = "${BPV}"
SRCREV = "cdbd244f7d1de53c7228f6758866c083ae71a3c3"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/chef/chef.git;branch=main;protocol=https \
    file://0001-chang-ksh-to-sh.patch \
    "

inherit ruby

DEPENDS += " \
        ruby-native \
        pry-native \
        yard-native \
        bundler-native \
        "

RDEPENDS_${PN} += " \
        ruby \
        chef-zero \
        coderay \
        diff-lcs \
        erubis \
        hashie \
        highline \
        ipaddress \
        json \
        method-source \
        mime-types \
        mixlib-authentication \
        mixlib-cli \
        mixlib-config \
        mixlib-log \
        mixlib-shellout \
        net-ssh \
        net-ssh-gateway \
        net-ssh-multi \
        ohai \
        pry \
        rack \
        rest-client \
        slop \
        systemu \
        yajl-ruby \
        make \
        bash \
        "

RUBY_INSTALL_GEMS = "pkg/chef-${BPV}.gem"

FILES_${PN} += "${libdir}/ruby/gems/2.2.0/build_info"
FILES_${PN} += "${libdir}/ruby/gems/2.2.0/extensions"

do_install_prepend() {
	rake gem
}
