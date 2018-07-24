// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.baidu.carlife.protobuf;

public final class CarlifeProtocolVersionProto {
  private CarlifeProtocolVersionProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class CarlifeProtocolVersion extends
      com.google.protobuf.GeneratedMessage {
    // Use CarlifeProtocolVersion.newBuilder() to construct.
    private CarlifeProtocolVersion() {}
    
    private static final CarlifeProtocolVersion defaultInstance = new CarlifeProtocolVersion();
    public static CarlifeProtocolVersion getDefaultInstance() {
      return defaultInstance;
    }
    
    public CarlifeProtocolVersion getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_fieldAccessorTable;
    }
    
    // required int32 majorVersion = 1;
    public static final int MAJORVERSION_FIELD_NUMBER = 1;
    private boolean hasMajorVersion;
    private int majorVersion_ = 0;
    public boolean hasMajorVersion() { return hasMajorVersion; }
    public int getMajorVersion() { return majorVersion_; }
    
    // required int32 minorVersion = 2;
    public static final int MINORVERSION_FIELD_NUMBER = 2;
    private boolean hasMinorVersion;
    private int minorVersion_ = 0;
    public boolean hasMinorVersion() { return hasMinorVersion; }
    public int getMinorVersion() { return minorVersion_; }
    
    public final boolean isInitialized() {
      if (!hasMajorVersion) return false;
      if (!hasMinorVersion) return false;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (hasMajorVersion()) {
        output.writeInt32(1, getMajorVersion());
      }
      if (hasMinorVersion()) {
        output.writeInt32(2, getMinorVersion());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasMajorVersion()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, getMajorVersion());
      }
      if (hasMinorVersion()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, getMinorVersion());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeDelimitedFrom(input).buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeDelimitedFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion result;
      
      // Construct using com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion();
        return builder;
      }
      
      protected com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion.getDescriptor();
      }
      
      public com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion getDefaultInstanceForType() {
        return com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion) {
          return mergeFrom((com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion other) {
        if (other == com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion.getDefaultInstance()) return this;
        if (other.hasMajorVersion()) {
          setMajorVersion(other.getMajorVersion());
        }
        if (other.hasMinorVersion()) {
          setMinorVersion(other.getMinorVersion());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 8: {
              setMajorVersion(input.readInt32());
              break;
            }
            case 16: {
              setMinorVersion(input.readInt32());
              break;
            }
          }
        }
      }
      
      
      // required int32 majorVersion = 1;
      public boolean hasMajorVersion() {
        return result.hasMajorVersion();
      }
      public int getMajorVersion() {
        return result.getMajorVersion();
      }
      public Builder setMajorVersion(int value) {
        result.hasMajorVersion = true;
        result.majorVersion_ = value;
        return this;
      }
      public Builder clearMajorVersion() {
        result.hasMajorVersion = false;
        result.majorVersion_ = 0;
        return this;
      }
      
      // required int32 minorVersion = 2;
      public boolean hasMinorVersion() {
        return result.hasMinorVersion();
      }
      public int getMinorVersion() {
        return result.getMinorVersion();
      }
      public Builder setMinorVersion(int value) {
        result.hasMinorVersion = true;
        result.minorVersion_ = value;
        return this;
      }
      public Builder clearMinorVersion() {
        result.hasMinorVersion = false;
        result.minorVersion_ = 0;
        return this;
      }
    }
    
    static {
      com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.getDescriptor();
    }
    
    static {
      com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.internalForceInit();
    }
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n!CarlifeProtocolVersionProto.proto\022\032com" +
      ".baidu.carlife.protobuf\"D\n\026CarlifeProtoc" +
      "olVersion\022\024\n\014majorVersion\030\001 \002(\005\022\024\n\014minor" +
      "Version\030\002 \002(\005"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_descriptor,
              new java.lang.String[] { "MajorVersion", "MinorVersion", },
              com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion.class,
              com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
}
