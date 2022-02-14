DESCRIPTION = "Oslo Rootwrap"
HOMEPAGE = "https://launchpad.net/oslo"
SECTION = "devel/python"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c46f31914956e4579f9b488e71415ac8"

PV = "6.1.0+git${SRCPV}"
SRCREV = "ff61e1577c3aaec6242951876263108559d1a203"

SRCNAME = "oslo.rootwrap"
SRC_URI = "git://github.com/openstack/${SRCNAME}.git;protocol=https"

S = "${WORKDIR}/git"

inherit setuptools3

# DEPENDS_default: python3-pip

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

# RDEPENDS_default: 
RDEPENDS_${PN} += " \
        python3-pbr \
        python3-six \
        "
