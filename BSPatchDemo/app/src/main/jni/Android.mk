LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := bspatcher
LOCAL_SRC_FILES :=*.c\

include $(BUILD_SHARED_LIBRARY)