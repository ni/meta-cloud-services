SUMMARY = "Common testing tools used in the Salt Stack projects"
HOMEPAGE = "https://github.com/saltstack/salt-testing"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f36f1e9e3e30f90180efdf7e40d943e5"
SRCNAME = "salt-testing"

FILESEXTRAPATHS_append := "${THISDIR}/${PN}"

SRC_URI = "https://github.com/saltstack/salt-testing/archive/v${PV}.tar.gz;downloadfilename=salt-testing-v${PV}.tar.gz \
           file://0001-Add-ptest-output-option-to-test-suite.patch \
           "
SRC_URI[md5sum] = "35a8332736430624ef8f8a78d97ecb03"
SRC_URI[sha256sum] = "5a45c5540f9ee250f1a3d2d9b70eb015fad9bd51a1bd1a04dc56cc55a5298617"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} = "\
                  python3-unittest \
"

inherit setuptools3
