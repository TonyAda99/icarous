cmake_minimum_required(VERSION 2.6.4)
project(CFS_SCH C)

include_directories(fsw/public_inc)
include_directories(fsw/mission_inc)
include_directories(fsw/platform_inc)
include_directories(fsw/src)
include_directories(../inc/msgids)

aux_source_directory(fsw/src APP_SRC_FILES)

# Create the app module
add_cfe_app(sch ${APP_SRC_FILES})

add_cfe_tables(sch "fsw/tables/sch_def_msgtbl.c" "fsw/tables/sch_def_schtbl.c")