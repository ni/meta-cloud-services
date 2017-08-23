SUMMARY = "This pytest plugin will allow the Salt Daemons to be used in tests."
HOMEPAGE = "https://github.com/saltstack/pytest-salt"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa818a259cbed7ce8bc2a22d35a464fc"

SRCNAME = "pytest-salt"
SRC_URI = "https://github.com/saltstack/${SRCNAME}/archive/v${PV}.tar.gz;downloadfilename=${SRCNAME}-v${PV}.tar.gz"

SRC_URI[md5sum] = "027d359c10f7269a10180415aeac2af2"
SRC_URI[sha256sum] = "06edd40f9c6981a836b84088cc7f5888d777b2c8f2376d4b465f7a1139b39e6a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} = " \
    python-pytest \
    python-pytest-tempdir \
    python-pytest-helpers-namespace \
    python-psutil \
    "
