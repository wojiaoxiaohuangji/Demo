// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.baidu.carlife.protobuf;

public final class CarlifeMusicInitProto {
  private CarlifeMusicInitProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class CarlifeMusicInit extends
      com.google.protobuf.GeneratedMessage {
    // Use CarlifeMusicInit.newBuilder() to construct.
    private CarlifeMusicInit() {}
    
    private static final CarlifeMusicInit defaultInstance = new CarlifeMusicInit();
    public static CarlifeMusicInit getDefaultInstance() {
      return defaultInstance;
    }
    
    public CarlifeMusicInit getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.carlife.protobuf.CarlifeMusicInitProto.internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.carlife.protobuf.CarlifeMusicInitProto.internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_fieldAccessorTable;
    }
    
    // required int32 sampleRate = 1;
    public static final int SAMPLERATE_FIELD_NUMBER = 1;
    private boolean hasSampleRate;
    private int sampleRate_ = 0;
    public boolean hasSampleRate() { return hasSampleRate; }
    public int getSampleRate() { return sampleRate_; }
    
    // required int32 channelConfig = 2;
    public static final int CHANNELCONFIG_FIELD_NUMBER = 2;
    private boolean hasChannelConfig;
    private int channelConfig_ = 0;
    public boolean hasChannelConfig() { return hasChannelConfig; }
    public int getChannelConfig() { return channelConfig_; }
    
    // required int32 sampleFormat = 3;
    public static final int SAMPLEFORMAT_FIELD_NUMBER = 3;
    private boolean hasSampleFormat;
    private int sampleFormat_ = 0;
    public boolean hasSampleFormat() { return hasSampleFormat; }
    public int getSampleFormat() { return sampleFormat_; }
    
    public final boolean isInitialized() {
      if (!hasSampleRate) return false;
      if (!hasChannelConfig) return false;
      if (!hasSampleFormat) return false;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (hasSampleRate()) {
        output.writeInt32(1, getSampleRate());
      }
      if (hasChannelConfig()) {
        output.writeInt32(2, getChannelConfig());
      }
      if (hasSampleFormat()) {
        output.writeInt32(3, getSampleFormat());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasSampleRate()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, getSampleRate());
      }
      if (hasChannelConfig()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, getChannelConfig());
      }
      if (hasSampleFormat()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, getSampleFormat());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeDelimitedFrom(input).buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeDelimitedFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit result;
      
      // Construct using com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit();
        return builder;
      }
      
      protected com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit.getDescriptor();
      }
      
      public com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit getDefaultInstanceForType() {
        return com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit) {
          return mergeFrom((com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit other) {
        if (other == com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit.getDefaultInstance()) return this;
        if (other.hasSampleRate()) {
          setSampleRate(other.getSampleRate());
        }
        if (other.hasChannelConfig()) {
          setChannelConfig(other.getChannelConfig());
        }
        if (other.hasSampleFormat()) {
          setSampleFormat(other.getSampleFormat());
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
              setSampleRate(input.readInt32());
              break;
            }
            case 16: {
              setChannelConfig(input.readInt32());
              break;
            }
            case 24: {
              setSampleFormat(input.readInt32());
              break;
            }
          }
        }
      }
      
      
      // required int32 sampleRate = 1;
      public boolean hasSampleRate() {
        return result.hasSampleRate();
      }
      public int getSampleRate() {
        return result.getSampleRate();
      }
      public Builder setSampleRate(int value) {
        result.hasSampleRate = true;
        result.sampleRate_ = value;
        return this;
      }
      public Builder clearSampleRate() {
        result.hasSampleRate = false;
        result.sampleRate_ = 0;
        return this;
      }
      
      // required int32 channelConfig = 2;
      public boolean hasChannelConfig() {
        return result.hasChannelConfig();
      }
      public int getChannelConfig() {
        return result.getChannelConfig();
      }
      public Builder setChannelConfig(int value) {
        result.hasChannelConfig = true;
        result.channelConfig_ = value;
        return this;
      }
      public Builder clearChannelConfig() {
        result.hasChannelConfig = false;
        result.channelConfig_ = 0;
        return this;
      }
      
      // required int32 sampleFormat = 3;
      public boolean hasSampleFormat() {
        return result.hasSampleFormat();
      }
      public int getSampleFormat() {
        return result.getSampleFormat();
      }
      public Builder setSampleFormat(int value) {
        result.hasSampleFormat = true;
        result.sampleFormat_ = value;
        return this;
      }
      public Builder clearSampleFormat() {
        result.hasSampleFormat = false;
        result.sampleFormat_ = 0;
        return this;
      }
    }
    
    static {
      com.baidu.carlife.protobuf.CarlifeMusicInitProto.getDescriptor();
    }
    
    static {
      com.baidu.carlife.protobuf.CarlifeMusicInitProto.internalForceInit();
    }
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033CarlifeMusicInitProto.proto\022\032com.baidu" +
      ".carlife.protobuf\"S\n\020CarlifeMusicInit\022\022\n" +
      "\nsampleRate\030\001 \002(\005\022\025\n\rchannelConfig\030\002 \002(\005" +
      "\022\024\n\014sampleFormat\030\003 \002(\005"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_baidu_carlife_protobuf_CarlifeMusicInit_descriptor,
              new java.lang.String[] { "SampleRate", "ChannelConfig", "SampleFormat", },
              com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit.class,
              com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit.Builder.class);
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
